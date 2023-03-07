   function forEach(array,userCallBackFunction){
    	for(let i=0;i<array.length;i++){
    		userCallBackFunction(i,array[i]);
    	}
    }