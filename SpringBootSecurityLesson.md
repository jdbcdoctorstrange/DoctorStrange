# Spring Boot Security
## Learning Objectives
* Setting up Spring Boot Security
* Creating a custom login screen
* Implementing role-based permissions
* Designating users with specific roles
* Implementing a registration page
* Implementing database-based authentication
* Working with a Service class
* Implementing a function to autoload data on application start
* Implementing a Command Line Runner class

## The Walkthrough

1. Create a Spring Boot Application
	* Name it SpringBoot_17
	* Add the dependencies for security, web and thymeleaf
	* Hit next until you finish the wizard, and then wait until it's done.


2. Setup H2
	* Add the dependencies by:
	* Open the pom.xml file
    	* Add the following xml right before the line that reads:  &lt;/dependencies>
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
```


Edit the application.properties file to look like this:
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=create
```

3. Import your maven dependencies:
    * Either click the Import Changes link in the lower right hand corner, or
    * Right-click your project and click Maven -> Re-Import
    * Wait for the background tasks to complete


4. Create the User Class
    * Right click on com.example.demo and click New -> Class
    * Name it User.java
    * Edit it to look like this:
```java
@Entity
@Table(name="USER_DATA")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
```

5. Autogenerate getters and setters
    * Right click on the word User
    * Click Generate -> Getters and Setters

2. Add loaded constructor to User
    * Edit the User.java file
    * Right-click the word Java and Select Generate -> Constructor
    * Click on email, password, firstName, lastName, enabled, username
    * Click OK

3. Add default constructor to User
    * Edit the User.java file
    * Right-click the word Java and Select Generate -> Constructor
    * Click on the "Select None" button
    * Click OK

6. Create the Role Class
    * Right click on com.example.demo and click New -> Class
    * Name it Role.java
    * Edit it to look like this:
```java
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Collection<User> users;
}
```

7. Autogenerate getters and setters
    * Right click on the word Role
    * Click Generate -> Getters and Setters

4. Add loaded constructor to Role
    * Edit the Role.java file
    * Right-click the word Java and Select Generate -> Constructor
    * Click on role
    * Click OK

5. Add default constructor to Role
    * Edit the Role.java file
    * Right-click the word Java and Select Generate -> Constructor
    * Click on the "Select None" button
    * Click OK

8. Create a User Repository
    * Right click on com.example.demo and click New -> Class
    * Name it UserRepository.java
    * Edit it to look like this:
```java
	import org.springframework.data.repository.CrudRepository;

	public interface UserRepository extends CrudRepository<User, Long>{
	  User findByUsername(String username);
	}
```

9. Create a Role Repository
    * Right click on com.example.demo and click New -> Class
    * Name it RoleRepository.java
    * Edit it to look like this:
```java
	import org.springframework.data.repository.CrudRepository;

	public interface RoleRepository extends CrudRepository<Role, Long>{
	}
```

10. Create a SecurityConfiguration Class
	* Right click on com.example.demo and click New -> Class
	* Name it SecurityConfiguration.java
	* Edit it to look like this:

		```java
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.security.config.annotation.authentication
			.builders.AuthenticationManagerBuilder;
		import org.springframework.security.config.annotation.web
			.builders.HttpSecurity;
		import org.springframework.security.config.annotation.web
			.configuration.EnableWebSecurity;
		import org.springframework.security.config.annotation.web.configuration
			.WebSecurityConfigurerAdapter;
		import org.springframework.security.core.userdetails.UserDetailsService;
		import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
		import org.springframework.security.crypto.password.PasswordEncoder;
		import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

		@Configuration
		@EnableWebSecurity
		public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

			@Bean
			public PasswordEncoder encoder() {
					return new BCryptPasswordEncoder();
			}

			@Autowired
			private UserRepository userRepository;

			@Override
			public UserDetailsService userDetailsServiceBean() throws Exception {
					return new SSUserDetailsService(userRepository);
			}

			@Override
			protected void configure(HttpSecurity http) throws Exception{
					http
									.authorizeRequests()
											.antMatchers("/", "/h2/**", "/register").permitAll()
											.anyRequest().authenticated()
									.and()
									.formLogin()
											.loginPage("/login").permitAll()
									.and()
									// logout() removes the user from the current session
									// default timeout is 20 minutes
									.logout()
											.logoutRequestMatcher(
												new AntPathRequestMatcher("/logout"))
											.logoutSuccessUrl("/login").permitAll().permitAll()
									.and()
									.httpBasic();
					http
									.csrf().disable();
					http
									.headers().frameOptions().disable();
			}

			@Override
			protected void configure(AuthenticationManagerBuilder auth)
				throws Exception{

					//Allows database authentication
					auth.userDetailsService(userDetailsServiceBean())
						.passwordEncoder(encoder());

			}
		```

11. Create the SSUserDetailsService
    * Right click on com.example.demo and click New -> Class
    * Name it SSUserDetailsService.java
    * Edit it to look like this:

		```java
		import org.springframework.security.core.GrantedAuthority;
		import org.springframework.security.core.authority.SimpleGrantedAuthority;
		import org.springframework.security.core.userdetails.UserDetails;
		import org.springframework.security.core.userdetails.UserDetailsService;
		import org.springframework.security.core.userdetails
				.UsernameNotFoundException;
		import org.springframework.stereotype.Service;
		import javax.transaction.Transactional;
		import java.util.HashSet;
		import java.util.Set;

		@Transactional
		@Service
		public class SSUserDetailsService implements UserDetailsService {

		    private UserRepository userRepository;

		    public SSUserDetailsService(UserRepository userRepository) {
		        this.userRepository = userRepository;
		    }

		    @Override
		    public UserDetails loadUserByUsername(String username)
								throws UsernameNotFoundException {
		        try {
		            User user = userRepository.findByUsername(username);
		            if(user == null) {
		                return null;
		            }

		            return new org.springframework.security.core.userdetails.User(
		                    user.getUsername(),
		                    user.getPassword(),
		                    getAuthorities(user));
		        }
		        catch (Exception e) {
		            throw new UsernameNotFoundException("User not found");
		        }
		    }

		    private Set<GrantedAuthority> getAuthorities(User user) {
		        Set<GrantedAuthority> authorities = new HashSet<>();
		        for(Role role : user.getRoles()) {
		            GrantedAuthority grantedAuthority =
											new SimpleGrantedAuthority(role.getRole());
		            authorities.add(grantedAuthority);
		        }
		        return authorities;
		    }
		}
		```

12. Add a DataLoader Class
    * Right-click on  and click New -> Class
    * Name it DataLoader.java
    * Edit the contents to look like this:
		```java
		@Component
		public class DataLoader implements CommandLineRunner{

		    @Autowired
		    UserRepository userRepository;

		    @Autowired
		    RoleRepository roleRepository;

		    @Override
		    public void run(String... strings) throws Exception {
		        System.out.println("Loading data . . .");

		        roleRepository.save(new Role("USER"));
		        roleRepository.save(new Role("ADMIN"));

		        Role adminRole = roleRepository.findByRole("ADMIN");
		        Role userRole = roleRepository.findByRole("USER");

		        User user = new User("bob@bob.com","bob","Bob","Bobberson", true, "bob");
		        user.setRoles(Arrays.asList(userRole));
		        userRepository.save(user);

		        user = new User("jim@jim.com","jim","Jim","Jimmerson", true, "jim");
		        user.setRoles(Arrays.asList(userRole));
		        userRepository.save(user);

		        user = new User("admin@secure.com","password","Admin","User", true, "admin");
		        user.setRoles(Arrays.asList(adminRole));
		        userRepository.save(user);

		        user = new User("sam@every.com","password","Sam","Everyman", true, "everyman");
		        user.setRoles(Arrays.asList(userRole, adminRole));
		        userRepository.save(user);
		    }
		}

		```

12. Create the Controller
    * Name it HomeController.java
    * Edit it to look like this:

		```java
		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.RequestMapping;

		@Controller
		public class HomeController {
		    @RequestMapping("/")
		    public String index(){
		        return "index";
		    }

		    @RequestMapping("/login")
		    public String login(){
		        return "login";
		    }

		    @RequestMapping("/secure")
		    public String secure(){
		        return "secure";
		    }
		}
		````

13. Create the Login Template
	  * Name it login.html
	  * Edit it to look like this:
```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>
<form th:action="@{/login}" method="post">
    <div><label>
				User Name : <input type="text" name="username"/>
		</label></div>
    <div><label>
				Password: <input type="password" name="password"/>
		</label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>
```

5. Create a Template
  	* Right click on templates and click New -> Html
  	* Name it index.html
  	* Edit it to look like this:

	```html
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8" />
	    <title>Title</title>
	</head>
	<body>
	<h2>Insecure Page</h2>
	<a href="/secure">Secure Page</a>
	</body>
	</html>
	```

15. Create a Secure Template
  	* Right click on templates and click New -> Html
	  * Name it secure.html
	  * Edit it to look like this:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
<h3>Secure Page</h3>
<a href="/logout">logout</a>
</body>
</html>
```

16. Run your application and open a browser, and you should see this:
![](https://github.com/ajhenley/unofficialguides/blob/master/IntroToSpringBoot/img/Lesson21a.png )

If you click on the secure page link, you should see this:
![](https://github.com/ajhenley/unofficialguides/blob/master/IntroToSpringBoot/img/Lesson21b.png )

But you won't be able to login because there are no accounts in the database. To add them, navigate to the URL http://localhost:8080/h2-console/ and you will see this:
![](https://github.com/ajhenley/unofficialguides/blob/master/IntroToSpringBoot/img/Lesson21d.png )

If you click on the Connect button at the bottom, you should see this:
![](https://github.com/ajhenley/unofficialguides/blob/master/IntroToSpringBoot/img/Lesson21e.png )

And you can post this sql script in the window on the right:
```sql
INSERT INTO ROLE VALUES(1, 'USER');
INSERT INTO ROLE VALUES(2, 'ADMIN');
INSERT INTO USER_DATA VALUES (1, 'jim@jim.com', TRUE, 'Jim', 'Jimmerson', 'password', 'jim');
INSERT INTO USER_DATA VALUES (2, 'bob@bob.com', TRUE, 'Bob', 'Bobberson', 'password', 'bob');
INSERT INTO USER_DATA VALUES (3, 'admin@admin.com', TRUE, 'Admin', 'User', 'password', 'admin');
INSERT INTO USER_DATA_ROLES VALUES (1,1);
INSERT INTO USER_DATA_ROLES VALUES (2,1);
INSERT INTO USER_DATA_ROLES VALUES (3,1);
INSERT INTO USER_DATA_ROLES VALUES (3,2);
```

And click on the Run button at the top of the script and you should see something like this:
![](https://github.com/ajhenley/unofficialguides/blob/master/IntroToSpringBoot/img/Lesson21f.png )

You should now be able to go to the URL http://localhost:8080/login and login with the account jim and password password.
