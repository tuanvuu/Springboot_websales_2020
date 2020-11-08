<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="row">

	<c:forEach var="o" items="${orders}">
		<c:choose>
			<c:when test="${o.status == 1}">
			
			</c:when>
			<c:otherwise>
				<img class="img-wait" alt="" src="/static/images/order_empty.png" />
			</c:otherwise>
		</c:choose>
	</c:forEach>

</div>