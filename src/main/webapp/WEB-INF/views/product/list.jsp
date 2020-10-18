<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:forEach var="p" items="${list}">
<div>
<p>${p.name} - ${p.unitPrice}</p>
</div>
</c:forEach>

