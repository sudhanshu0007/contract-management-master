package com.sampana.cms.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.ResponseDTO;
import com.sampana.cms.model.User;
import com.sampana.cms.repository.UserRepository;
import com.sampana.cms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	/*
	 * @GetMapping("/users")
	 * 
	 * @PostMapping("/users")
	 * 
	 * @GetMapping("/users/{id}")
	 * 
	 * @DeleteMapping("/users/{id}")
	 * 
	 * @PutMapping("/users/{id}")
	 */

	@GetMapping("/check")
	public String hello() {
		return "helloWorld!!";
	}

	@GetMapping("/{id}")
	public List<User> getUser(@PathVariable("id") long id) {
		return userService.getUsers(id);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getFullName());
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get", headers="Accept=application/json")
    public List<User> getAllUser() {
        List<User> tasks=userService.getUser();
        return tasks;

    }
	@PostMapping("/save")
	public ResponseDTO createBookDetails(@RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}
	
	
/*	
	
	
	package com.sampana.cms.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





@Controller
@RequestMapping("/client")
public class LoginController {


    /*@RequestMapping(value= "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../template/login");
        return modelAndView;
    }*/


   /* @RequestMapping(value= "/register", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../template/register");
        return modelAndView;
    }*/
	
	@GetMapping("/home")
public String register() {
	return"../template/register.html";
}
	/*https://grokonez.com/java-integration/integrate-jquery-ajax-post-get-spring-boot-web-service
*/	
	
	
	/*for saveing user*/
	/*@PostMapping("/save")
	public ResponseDTO createBookDetails(@RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}*/
	
	
	/*@Override
	public ResponseDTO saveUser(UserDTO userDTO) {
		ResponseDTO responseDTO = null;
		if (userDTO != null) {
			try {
				User user = getUserObj(userDTO);
				user = userRepository.save(user);
				userDTO = getUserDTOObj(user);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return responseDTO;
	}
	private UserDTO getUserDTOObj(User user) {
		UserDTO userDTO = null;
		if (null != user) {
			userDTO = new UserDTO();
			userDTO.setUserName(user.getUserName());
			userDTO.setFullName(user.getFullName());
			userDTO.setEmail(user.getEmail());;
			userDTO.setPassword(user.getPassword());
			userDTO.setDeleted(user.getDeleted());
			userDTO.setUserStatusId(user.getUserStatusId());
			

		}
		return userDTO;

	}
private User getUserObj(UserDTO userDTO) {
		
		User  user=null;
		
		if(null !=userDTO) {
			user=new User();
			if(null !=userDTO.getId())
				user.setId(userDTO.getId());
			user.setCreatedAt(DateUtils.getDateObj(userDTO.getCreatedAt(), IConstants.DATE_FORMAT));
			user.setDeleted(userDTO.getDeleted());
			//user.setDeletedAt(DateUtils.getDateObj(userDTO.getDeletedAt(), IConstants.DATE_FORMAT));
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setFullName(userDTO.getFullName());
			//user.setUpdatedAt(DateUtils.getDateObj(userDTO.getUpdatedAt(), IConstants.DATE_FORMAT));
			user.setUserName(userDTO.getUserName());
			user.setUserStatusId(userDTO.getUserStatusId());
		}
		return user;
	}
*/
	
}

*/	
	
/*	

<html  class="no-js" xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">


		<!-- Website CSS style -->
		<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<!-- <link rel="stylesheet" href="style.css"> -->
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<title>Admin</title>
		<style type="text/css">
		#playground-container {
    height: 500px;
    overflow: hidden !important;
    -webkit-overflow-scrolling: touch;
}
body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background:url(https://i.ytimg.com/vi/4kfXjatgeEU/maxresdefault.jpg);
 	font-family: 'Oxygen', sans-serif;
	    background-size: cover;
}

.main{
 	margin:50px 15px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}
.form-control {
    height: auto!important;
padding: 8px 12px !important;
}
.input-group {
    -webkit-box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
    -moz-box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
    box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;
}
#button {
    border: 1px solid #ccc;
    margin-top: 28px;
    padding: 6px 12px;
    color: #666;
    text-shadow: 0 1px #fff;
    cursor: pointer;
    -moz-border-radius: 3px 3px;
    -webkit-border-radius: 3px 3px;
    border-radius: 3px 3px;
    -moz-box-shadow: 0 1px #fff inset, 0 1px #ddd;
    -webkit-box-shadow: 0 1px #fff inset, 0 1px #ddd;
    box-shadow: 0 1px #fff inset, 0 1px #ddd;
    background: #f5f5f5;
    background: -moz-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #eeeeee));
    background: -webkit-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -o-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: -ms-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    background: linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5', endColorstr='#eeeeee', GradientType=0);
}
.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 400px;
    padding: 10px 40px;
	background:#009edf;
	    color: #FFF;
    text-shadow: none;
	-webkit-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
-moz-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);

}
span.input-group-addon i {
    color: #009edf;
    font-size: 17px;
}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}
		
		
		
		</style>
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script>
        /*  $(document).ready(function() {
			
			// SUBMIT FORM
		    $("#userForm").submit(function(event) {
		    	
		    	console.log("hello aaac");
				
			});
         }); */
		
		$(document).ready(function() {
			
			// SUBMIT FORM
		    $("#userForm").submit(function(event) {
		    	
		    	console.log("hello aaac");
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
				console.log("hello aaa");
			});
		    
		    
		    function ajaxPost(){
		    	alert("reachefd");
		    	// PREPARE FORM DATA
		    	var formData = {
		    			
		    			userName:$("#userName").val(),
						email:$("#email").val(),
						fullName:$("#fullName").val(),
						password:$("#password").val()
					
						
		    	}
		    	
		    	// DO POST
		    	$.ajax({
					type :"POST",
					contentType : "application/json",
					url :  "/user/save",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if(result.status == "Done"){
							$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
														"Post Successfully! <br>" +
														"---> Customer's Info: FirstName = " + 
														result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
						}else{
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});
		    	
		    	// Reset FormData after Posting
		    	resetData();
		 
		    }
		    
		    function resetData(){
				$("#email").val(),
				$("#fullName").val(),
				$("#password").val(),
			$("#userName").val()
		    }
		});
 
</script>
	</head>
	<body>
	<div id="" align="center"></div>
		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<!-- <form class="" method="get" th:action="@{/register}"> -->
						<form id="userForm">
						
						
						<div class="form-group">
							<label for="fullname" class="cols-sm-2 control-label">Full Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="fullname"   placeholder="Enter your Full Name"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your email"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>

					
							<div class="form-group ">
							<button   type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						</form>
						</div>
                      </div>
			</div>

		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   <!--  <script src="js/bootstrap.min.js"></script> -->
      
	</body>
</html>





	*/	
}
