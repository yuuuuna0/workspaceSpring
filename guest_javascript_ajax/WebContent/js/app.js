
import * as View from "./view.js";
//import {render as Render} from "./view.js";
//import {render} from "./view.js";
import * as Service from "./service.js";
import * as URL from "./request-url.js";

 /**
 메뉴객체이벤트등록
 */
 
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');


menuGuestHome.addEventListener('click',function(e){
	/*
	let templateHtml=document.querySelector('#guest-main-template');
	document.querySelector('#content').innerHTML = templateHtml.innerHTML;
	*/
	/*
	let templateHtml=document.querySelector('#guest-main-template').innerHTML;
	let bindTemplate=Handlebars.compile(templateHtml);
	let resultTemplate=bindTemplate({});	//제이슨객체나 제이슨템플릿 넣어줌
	
	document.querySelector('#content').innerHTML = resultTemplate;
	*/
	View.render("#guest-main-template",{},"#content");
	e.preventDefault();
	//console.log(render);

});

menuGuestList.addEventListener('click',function(e){
	let jsonResult=Service.guestService('GET',URL.GUEST_LIST_URL,'');
	View.render("#guest-list-template",jsonResult,"#content");
	e.preventDefault();
});
menuGuestWriteForm.addEventListener('click',function(e){
	View.render("#guest-write-form-template",{},"#content");
	e.preventDefault();
});


menuGuestHome.click();		//초기 로딩시에 home anchor click 이벤트를 trigger


document.addEventListener('click',function(e){
	/************* Element 속성 ********** */
	console.log("event객체: "+e);
	console.log("event target객체: "+e.target);
	console.log("event target객체 id: "+e.target.id);
	console.log("event target객체 id: "+e.target.getAttribute('id'));
	console.log("event target객체 className: "+e.target.className);
	console.log("event target객체 classList: "+e.target.classList);
	console.log("event target객체 classList.contains('guest_item_a'): "+e.target.classList.contains('guest_item_a'));
	
	/****************** guest_detail *************** */
	if(e.target.classList.contains('guest_item_a')){
		//guest_detail 요청
		/**
		<<e.target>>
		<a href="#" class="user guest_item_a" guest_no="585"> 3시40분 시작</a>
		 */
		let params='guest_no='+e.target.getAttribute("guest_no");
		let jsonResult=Service.guestService('GET',URL.GUEST_DETAIL_URL,params);
		View.render("#guest-detail-template",jsonResult,"#content");
	}
	/****************** guest_delete_action *************** */
	if(e.target.id=='btn_guest_remove_action'){
		let params='guest_no='+e.target.getAttribute("guest_no");
		let jsonResult=Service.guestService('POST',URL.GUEST_REMOVE_ACTION_URL,params);
		if(jsonResult.code==1){
			menuGuestList.click();
		} else{
			alert(jsonResult.msg);
		}
	}
	/****************** guest_write_action **************/
	if(e.target.id=='btn_guest_write_action'){
		if (document.f.guest_name.value == "") {
		alert("이름을 입력하십시요.");
		document.f.guest_name.focus();
		return false;
	}
	if (document.f.guest_email.value == "") {
		alert("이메일을 입력하십시요.");
		document.f.guest_email.focus();
		return false;
	}
	if (document.f.guest_homepage.value == "") {
		alert("홈페이지를 입력하십시요.");
		document.f.guest_homepage.focus();
		return false;
	}

	if (document.f.guest_title.value == "") {
		alert("제목을 입력하십시요.");
		document.f.guest_title.focus();
		return false;
	}
	if (document.f.guest_content.value == "") {
		alert("내용을 입력하십시요.");
		document.f.guest_content.focus();
		return false;
	}
		const f=document.querySelector('#guest_write_form');
		const data=new FormData(f);
		const params=new URLSearchParams(data).toString();		//params는 변경되지 않으니까 const 타입으로 해주는게 좋음
		const jsonResult=Service.guestService('POST',URL.GUEST_WRITE_ACTION_URL,params);
		if(jsonResult.code==1){
			//view로 가려면 guest_no가 있어야 하는데 write_form에 안 들어있음,,,
			menuGuestList.click();
		} else{
			alert(jsonResult.msg);
		}
		
	}
	
	/****************** guest_modify_form ****************/
	if(e.target.id=='btn_guest_modify_form'){
		const params='guest_no='+e.target.getAttribute("guest_no");
		let jsonResult=Service.guestService('POST',URL.GUEST_MODIFY_FORM_URL,params);
		if(jsonResult.code==1){
			View.render('#guest-modify-form-template',jsonResult,"#content");
		} else {
			alert(jsonResult.msg);
		}
	}
	/****************** guest_modify_action ***************/
	if(e.target.id=='btn_guest_modify_action'){
		if (document.f.guest_name.value == "") {
		alert("이름을 입력하십시요.");
		document.f.guest_name.focus();
		return false;
	}
	if (document.f.guest_email.value == "") {
		alert("이메일을 입력하십시요.");
		document.f.guest_email.focus();
		return false;
	}
	if (document.f.guest_homepage.value == "") {
		alert("홈페이지를 입력하십시요.");
		document.f.guest_homepage.focus();
		return false;
	}

	if (document.f.guest_title.value == "") {
		alert("제목을 입력하십시요.");
		document.f.guest_title.focus();
		return false;
	}
	if (document.f.guest_content.value == "") {
		alert("내용을 입력하십시요.");
		document.f.guest_content.focus();
		return false;
	}
		const f=document.querySelector('#guest_modify_form');
		const data=new FormData(f);
		const params=new URLSearchParams(data).toString();		//params는 변경되지 않으니까 const 타입으로 해주는게 좋음
		const jsonResult=Service.guestService('POST',URL.GUEST_MODIFY_ACTION_URL,params);
		if(jsonResult.code==1){
			const param='guest_no='+f.guest_no.value;
			const jsonResult=Service.guestService('GET',URL.GUEST_DETAIL_URL,param);
			View.render('#guest-detail-template',jsonResult,"#content");
		} else {
			alert(jsonResult.msg);
		}
	}
	/********************* 페이지 변환 *******************/
	if(e.target.id=='btn_guest_list'){
		menuGuestList.click();
	}
	if(e.target.id=='btn_guest_write_form'){
		menuGuestWriteForm.click();
	}
});
