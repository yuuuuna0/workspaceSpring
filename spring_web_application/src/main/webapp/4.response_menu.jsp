<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링응답[View , @ResponseBody]</h1><hr/>
	<a href='./'>메인메뉴</a>
	<ol>
		<li><a href='response_forward_view_name'>Controller가 view name(String) 을반환 [forward]</a></li>
		<li><a href='response_forward_view_object'>Controller가 view 객체[InternalResourceView]를반환 [forward]</a></li>
		<li><a href='response_redirect_view_name'>Controller가 view name(String)을반환 [redirect]</a></li>
		<li><a href='response_redirect_view_object'>Controller가 view 객체[RedirectView]을반환 [redirect]</a></li>
		
		<li><a href='response_xml_view_object'>Controller가 view 객체[XMLView]을반환 [출력]</a></li>
		<li><a href='response_xml_view_name'>Controller가 view name(String) [xmlView]을반환 [출력]</a></li>
		
		<li><a href='response_string'>Controller가 응답 text데이타를반환[@ResponseBody]</a></li>
		<li><a href='response_html'>Controller가 응답 html데이타를반환[@ResponseBody]</a></li>
		<li><a href='response_xml'>Controller가 응답 Dto객체를xml로반환[@ResponseBody]</a></li>
		<li><a href='response_json'>Controller가 응답 Dto객체를json로반환[@ResponseBody]</a></li>
		<!-- 
		<li><a href='rest_string.do'>Controller가 응답 text데이타를반환[@RestController]</a></li>
		<li><a href='rest_html.do'>Controller가 응답 html데이타를반환[@RestController]</a></li>
		<li><a href='rest_xml.do'>Controller가 응답 Dto객체를 xml로반환[@RestController]</a></li>
		<li><a href='rest_string.do'>Controller가 응답 text데이타를반환[@RestController @GetMapping]</a></li>
		<li><a href='rest_html.do'>Controller가 응답 html데이타를반환[@ResponseBody @GetMapping]</a></li>
		<li><a href='rest_xml.do'>Controller가 응답 Dto객체를 xml로반환[@ResponseBody @GetMapping]</a></li>
		 -->
	</ol>
</body>
</html>