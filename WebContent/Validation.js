// This is the name function
$(document).ready(function() {
	$('.error').hide();
	$('.ename').blur(function(event){
	 var data=$('.ename').val();
	if(validate_name(data))
	{
	$('.error').hide();
	}
	else
	{
	$('.error').show();
	event.preventDefault();
	} 
	});
	
	//This is for state
	$('.serror').hide();
	$('.state').blur(function(event){
	 var data=$('.state').val();
	if(validate_name(data))
	{
	$('.serror').hide();
	}
	else
	{
	$('.serror').show();
	event.preventDefault();
	} 
	});
	
	//this is for country
	$('.cerror').hide();
	$('.country').blur(function(event){
	 var data=$('.country').val();
	if(validate_name(data))
	{
	$('.cerror').hide();
	}
	else
	{
	$('.cerror').show();
	event.preventDefault();
	} 
	});
	
	

//This is for date of birth
	$('.derror').hide();
	$('.ddate').blur(function(event){
	var data=$('.ddate').val();
	if(validate_date(data))
	{
	$('.derror').hide();
	}
	else
	{
	$('.derror').show();
	event.preventDefault();
	}
	});
	

//This is for date of joining
	$('.djerror').hide();
	$('.djdate').blur(function(event){
	var data=$('.djdate').val();
	if(validate_date(data))
	{
	$('.djerror').hide();
	}
	else
	{
	$('.djerror').show();
	event.preventDefault();
	}
	});
	
//This for password	
	$('.perror').hide();
	$('.cconfpass').blur(function(event){
	if($('.ppassword').val() !=$('.cconfpass').val())
	{
		$('.perror').show();
		event.preventDefault();
	}
	else
	{
	$('.perror').hide();
	}
	});
	
//This is for phone number
	$('.pherror').hide();
	$('.phname').blur(function(event){
	var data=$('.phname').val();
	if(validate_phoneno(data))
	{
	$('.pherror').hide();
	}
	else
	{
	$('.pherror').show();
	event.preventDefault();
	}
	});
	
//This is for pincode
	$('.pinerror').hide();
	$('.pinname').blur(function(event){
	var data=$('.pinname').val();
	if(validate_pin(data))
	{
	$('.pinerror').hide();
	}
	else
	{
	$('.pinerror').show();
	event.preventDefault();
	}
	});
	
	//This is for number
	$('.stkerror').hide();
	$('.stkname').blur(function(event){
	var data=$('.stkname').val();
	if(validate_pin(data))
	{
	$('.stkerror').hide();
	}
	else
	{
	$('.stkerror').show();
	event.preventDefault();
	}
	});
	
//This is for email Id
	$('.errorEmail').hide();
	$('.vemailId').blur(function(event){
	 var email=$('.vemailId').val();
	if(valid_email(email))
	{
	$('.errorEmail').hide();
	}
	else
	{
	$('.errorEmail').show();
	event.preventDefault();
	} 
	});
});

//This is function for date
	function validate_date(date)
	{
	var pattern= new RegExp(/\b\d{4}[-]\d{1,2}[-]\d{1,2}\b/);
	return pattern.test(date);
	}
	
//This is function for name
	function validate_name(ph)
	{
	var pattern=new RegExp(/^[a-z]+$/);
	return pattern.test(ph);
	}
//This is function for phone number
	function validate_phoneno(ph)
	{
	var pattern=new RegExp(/^[0-9]{10}$/);
	return pattern.test(ph);
	}
//This is function for pincode
	function validate_pin(ph)
	{
	var pattern=new RegExp(/^[0-9]{6}$/);
	return pattern.test(ph);
	}
	//This is function for number
	function validate_pin(ph)
	{
	var pattern=new RegExp(/^[0-9]$/);
	return pattern.test(ph);
	}
//This is function for email id
	function valid_email(email)
	{
	var pattern= new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
	return pattern.test(email);
	}
