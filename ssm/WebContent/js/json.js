function sendJson(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/json_test",
				data:'{"id":"1","name":"电冰箱","price":"1999"}',
				contentType:"application/json;charset=utf-8",
				success:function(data){
					alert(data.id+":"+data.name);
				}
			});
		}