var stompClient = null;

function connect(){
	var socket = new SockJS('/chat');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){
		setConneted(true);
		console.log('session Cennected : '+ frame);
		stompClient.subscribe('/topic/user', function(message){
			socketUser(JSON.parse(message.body));
			});
	});
}

function socketUser(message){
	alert(message);
}