
function getResult(n){
       var amount = document.getElementById('amount' ).value;
       var num = document.getElementById('num' ).value;
       var unit = 100;
       var x = Math.floor((amount / num) / unit) * unit;
       var y = amount - (x * num);
	   var z = x + y; 
      document.getElementById( 'result').innerHTML =
             '한 사람당 ' + x + '원이고' +  '<br>' + n +'님은 '+  z + '원입니다. ' ;

		
}

