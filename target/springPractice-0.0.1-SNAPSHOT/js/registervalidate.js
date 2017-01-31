/**
 * 
 */

$(document).ready(
		function()
		{
			$('#registervalidate').validate(
									{
										rules:{
												
	        									email:{
	        												required:true,
	        												email:true,
	        												minlength:5,
	        												maxlength:30
	        											},
	        									password:{ 
	        												required:true,
	        												minlength:8,
	        												maxlength:30,
	        												customPassword:true
	        											 },
	        									customerName:{
	        												required:true,
	        												customName:true
	        												
	        											},
	        									address:{
	        												required:true
	        											},
	        									city:{
	        												required:true, 
	        												customName:true
	        											},
												
	        									mobileNumber:{
															required:true,															
															minlenght:10,
															maxlenght:15,
															customMobileNumber:true
															}
										},
	    
										messages:{
													
													email:{
																required:"Email address is required",
																email:"Email address not valid(example12@gmail.com)",
																minlength:"Min length is 5 characters",
																maxlength:"Max length is 30 characters"
															},
													password:{ 
																required:"Password is required",
																minlength:"Password must be 8 characters long",
																maxlength:"Max length is 10 characters" 
															},
													customerName:{
																required:"Enter Name"
																
															},
													address:{
																required:"Enter Address"
															},
													city:{
																required:"City is required"
															},
													
													mobileNumber:{
																required:"Enter Contact Number"																
																}
													}
									});
		}		);

$.validator.addMethod("customName",function(value,element)
		{
			return /^[a-zA-Z_/-]+$/.test(value);
		},"Alpha Characters Only.");


$.validator.addMethod("customPassword",function(value,element)
		{
			return /^[a-zA-Z0-9*@$!#%^&_/-]+$/.test(value);
		},"Alpha Characters,Numeric Characters and *@$!#%^& Only.");


$.validator.addMethod("customMobileNumber",function(value,element)
		{
			return /^[0-9]{10}$/.test(value);
		},"Number not valid(10 digit number)");


