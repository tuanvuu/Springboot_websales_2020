<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="row" id="${prod.id}">
	<div class="col-sm-5 text-center">
		<img class="detail-img" src="/static/images/products/${prod.image}">
	</div>
	<div class="col-sm-7">
		<ul class="detail-info">
			<li>Name: ${prod.name}</li>
			<li>Unit Price: <f:formatNumber value="${prod.unitPrice}"
					pattern="#,###.00" /> VNĐ
			</li>
			<li>Product Date: <f:formatDate value="${prod.productDate}"
					pattern="dd-MM-yyyy" />
			</li>
			<li>Category: ${prod.category.nameVN}</li>
			<li>Quantity: ${prod.quantity}</li>
			<li>Discount: <f:formatNumber value="${prod.discount}"
					type="percent" /></li>
			<li>View Count: ${prod.viewCount}</li>
			<li>Available: ${prod.available?'Yes':'No'}</li>
		</ul>
		<div class="row">
			<%@include file="btn-prod.jsp"%>
		</div>
	</div>
</div>

<div class="text-justify">${prod.description}</div>

<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#tab1">CÙNG LOẠI</a></li>
	<li><a data-toggle="tab" href="#tab2">YÊU THÍCH</a></li>
	<li><a data-toggle="tab" href="#tab3">ĐÃ XEM</a></li>
</ul>

<div class="tab-content">
	<div id="tab1" class="tab-pane fade in active">
		<div>
			<c:forEach var="p" items="${list}">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/static/images/products/${p.image}">
				</a>
			</c:forEach>
		</div>
	</div>
	<div id="tab2" class="tab-pane fade">
		<div>
			 <c:forEach var="p" items="${like}">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/static/images/products/${p.image}">
				</a>
			</c:forEach> 
		</div>
	</div>
	<div id="tab3" class="tab-pane fade">
		<div>
			<c:forEach var="p" items="${daXem}">
				<a href="/product/detail/${p.id}"> <img class="thumb-img"
					src="/static/images/products/${p.image}">
				</a>
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="dialog.jsp"%>

