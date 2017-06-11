<?php
//check if the script recieved a post or not
if($_SERVER['REQUEST_METHOD']=='POST'){
	
	//GETTING POST DATA
	
	$name=$_POST['name'];
	$sid=$_POST['sid'];
	$username=$_POST['username'];
	$email=$_POST['email'];
	$password=$_POST['password'];
	$batch=$_POST['batch'];
	
	//checking received values are blank or not
	if($name == ''|| $sid==''||$username=='' || $email==''|| $password==''|| $batch==''){
		echo 'please fill all values';
	}
	else{
		require_once('conn.php');//.connection to database 
		//check this email is existing or not
		$sql="SELECT * FROM stb WHERE email='$email'";
		//If variable check has some value from mysqli fetch array 
		//That means username or email already exist 
		$check = mysqli_fetch_array(mysqli_query($conn,$sql));
		
		//checking check has some values or not
		if(isset($check)){
			//If check has some value that means username already exist 
		echo 'email already exist';
		}
		else {
		//If username is not already exist 
		//Creating insert query 
			$sql="INSERT INTO stb (name,username,sid,email,password,batch) VALUES ('$name','$username','$sid','$email','$password','$batch')";
		//trying to insert the values to dba_close
		if(mysqli_query($conn,$sql)){
			echo 'successfully registered';
		}
		else{
			//incase any error occured
			echo 'oops ! please try aain';
		}
		}
		//closing the database connection
		mysqli_close($conn);
	}
	
	}else{
		echo 'error';
	}
//last 



?>