function hello() {
	alert('hello');
	
	var sum = new Function('a', 'b', 'return a + b');
	
	alert(sum(1,2));
			
	var x = 10;
	var y = 20;
	var a = eval("x * y") + "<br>";
	
	alert(a);
}

hello();
