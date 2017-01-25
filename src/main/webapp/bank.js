$(document)
		.ready(
				function() {
					$('#viewLink').click(function() {
						$("#viewForm").show();
						$("#openForm").hide();
						$("#openResults").hide();
						$("#viewResults").hide();
					});
					$('#openLink').click(function() {
						$("#openForm").show();
						$("#viewForm").hide();
						$("#openResults").hide();
						$("#viewResults").hide();
					});
					$('#openButton')
							.click(
									function() {
										var name = $("#name").val();
										var phoneNumber = $("#phoneNumber")
												.val();
										var data = {
											name : name,
											phoneNumber : phoneNumber
										};
										$
												.ajax({
													url : 'http://localhost:8080/cmad/online/bank/account',
													type : 'post',
													contentType : 'application/json',
													success : function(response) {
														$("#openResults")
																.html(
																		"Your Account No: "
																				+ response);
														$("#openForm").hide();
														$("#openResults")
																.show();
													},
													data : JSON.stringify(data)
												});
									});
					$('#viewButton')
							.click(
									function() {
										$
												.ajax({
													url : 'http://localhost:8080/cmad/online/bank/account/'
															+ $('#number')
																	.val(),
													type : 'get',
													accept : 'application/json',
													success : function(response) {
														$("#viewForm").hide();
														$("#acc_name")
																.html(
																		response.data.name);
														$("#acc_number")
																.html(
																		response.number);
														$("#acc_balance")
																.html(
																		response.balance);
														$("#acc_phoneNumber")
																.val(
																		response.data.phoneNumber);
														$("#viewResults")
																.show();
													}
												});
									});
				});