<%@ page contentType="text/plain; charset=euc-kr"%>
<%@ page import="java.util.List"%>
<%!	
	String[] keywords = {"AJAX","AJAX ���� ���α׷���",
						"AJA","AZERA","�ڶ���",
						"�ڶ�","�ڹ� ���α׷���",
			   			"�ڹ� ���� ������","�ڹٽ��͵�",
			   			"�ڹټ���","�ڹ�ĵ"};
	public List search(String keyword) {
		if (keyword == null || keyword.equals("")) 
			return java.util.Collections.EMPTY_LIST;
		keyword = keyword.toUpperCase();
		List result = new java.util.ArrayList(8);
		for ( int i = 0 ; i < keywords.length ; i++ ) {
			if (((String)keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}
%>

<%	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("keyword");
	List keywordList = this.search(keyword);
	out.print(keywordList.size());
	out.print("|");
	for (int i = 0 ; i < keywordList.size() ; i++) {
		String key = (String)keywordList.get(i);
		out.print(key);
		if (i < keywordList.size() - 1) {
			out.print(",");
		}
	}
%>

