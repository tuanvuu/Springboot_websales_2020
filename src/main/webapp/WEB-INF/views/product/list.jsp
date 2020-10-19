<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:forEach var="p" items="${list}">
	<div class="col-sm-4">
		<div class="thumbnail pro-icon-wraper">
			<a href="/product/detail/${p.id}"> <img class="estore-prod"
				src="/static/images/products/${p.image}">
			</a>

			<div class="caption">
				<p>${p.name}</p>
				<div data-id="${p.id}" class="pull-right">
					<button class="btn btn-sm btn-danger btn-add-to-cart">
						<i class="glyphicon glyphicon-shopping-cart"></i>
					</button>
					<button class="btn btn-sm btn-warning btn-like">
						<i class="glyphicon glyphicon-star"></i>
					</button>
					<button class="btn btn-sm btn-success btn-open-dialog"
						data-toggle="modal" data-target="#myModal">
						<i class="glyphicon glyphicon-envelope"></i>
					</button>
				</div>
				<p>${p.unitPrice}</p>
			</div>

			<c:choose>
				<c:when test="${p.discount > 0}">
					<img class="pro-icon" src="/static/images/sales-off-icon.gif">
				</c:when>
				<c:when test="${p.available}">
					<img class="pro-icon" src="/static/images/new-icon.gif">
				</c:when>
			</c:choose>

		</div>
	</div>
</c:forEach>
