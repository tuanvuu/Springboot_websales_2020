<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="panel panel-default">
	<div class="panel-heading">TÌM KIẾM</div>
	<div class="panel-body">
		<form action="/product/list-by-keywords" method="post">
			<input name="keywords" class="form-control"
				placeholder="Tìm kiếm" />
		</form>
	</div>
</div>


<div class="panel panel-default">
	<div class="panel-heading">DANH MỤC HÀNG HÓA</div>
	<div class="list-group">
		<c:forEach var="c" items="${cates}"	>
		<a href="/product/list-by-category/${c.id}" class="list-group-item">${c.nameVN}</a>	
		</c:forEach>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">HÀNG ĐẶC BIỆT</div>
	<div class="list-group">
		<a href="#" class="list-group-item">Hàng mới</a> <a href="#"
			class="list-group-item">Hàng bán chạy</a> <a href="#"
			class="list-group-item">Hàng yêu thích</a> <a href="#"
			class="list-group-item">Hàng giảm giá</a>
	</div>
</div>


