/**
 * 
 */
$(document).ready(function()
		{
	
			$('#loginvalidate').validate(
									{
										rules:{
											
											email:{
													required:true,
													email:true,													
													maxlength:30
											      },
											 password:{
												 	required:true,
												 	minlenght:8,
												 	maxlenght:30,
												 	customPassword:true
											 }
											
											
											},
										messages:{
												email:
													{
														required:"Email address is required",
														email:"Email address not valid(example91@gmail.com)",														
														maxlength:"Max length is 30 characters"
													},
													password:{
														required:"Password is required",
														minlength:"Min length is 5 characters",
														maxlength:"Max length is 30 characters"
														
													}
												  }
													
									});
			
		});

$.validator.addMethod("customPassword",function(value,element)
		{
			return /^[a-zA-Z0-9*@$!#%^&_/-]+$/.test(value);
		},"Alpha Characters,Numeric Characters and *@$!#%^& Only.");


