/**
*
 */
// import {ajaxRequest} from './request.js';
 function guestService(method,url,params){
	//ajax요청
	
	//new Promise();
	let returnJsonResult={};
	ajaxRequest(method,
				url,
				function(jsonResult){
					returnJsonResult=jsonResult;
				},
				params,
				false);
	return returnJsonResult;
}
 function ajaxRequest(method,url,callbackFuntion,params,async){
	let xhr=new XMLHttpRequest();
	
	url=(method=='GET' && params!=null)? url+'?'+params:url;
	async=async ? async:false;
	
	xhr.onload=function(){
		callbackFuntion(JSON.parse(xhr.responseText));
	}
	xhr.open(method,url,async);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xhr.send(method=='POST'? params:null);
}
export{guestService}