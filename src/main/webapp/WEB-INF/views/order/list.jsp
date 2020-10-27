<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">ĐƠN HÀNG ĐÃ MUA</h4>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Ngày đặt hàng</th>
				<th>Địa chỉ</th>
				<th>Tổng giá</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${orders}">
				<tr>
					<td>#${o.id}</td>
					<td><f:formatDate value="${o.orderDate}"
							pattern="hh:mm a, dd-MM-yyyy" /></td>
					<td>${o.address}</td>
					<td>$<f:formatNumber value="${o.amount}" pattern="#,###.00" />
					</td>
					<td><a href="/order/detail/${o.id}"
						class="btn btn-sm btn-warning"> <span
							class="glyphicon glyphicon-search"></span>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panel-footer"></div>
</div>