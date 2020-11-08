<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>


<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#tatca">Tất cả</a></li>
	<li><a data-toggle="tab" href="#xacnhan">Chờ xác nhận</a></li>
	<li><a data-toggle="tab" href="#danggiao">Đang giao</a></li>
	<li><a data-toggle="tab" href="#danhan">Đã giao</a></li>
	<li><a data-toggle="tab" href="#dahuy">Đã hủy</a></li>
</ul>

<div class="tab-content">
	<div id="tatca" class="tab-pane fade in active">
		<jsp:include page="_all-list.jsp" />
	</div>
	<div id="xacnhan" class="tab-pane fade">
		<jsp:include page="_wait-list.jsp" />
	</div>
	<div id="danggiao" class="tab-pane fade">
		<h3>Menu 2</h3>
		<p>Some content in menu 2.</p>
	</div>
	<div id="dagiao" class="tab-pane fade">
		<h3>Menu 2</h3>
		<p>Some content in menu 2.</p>
	</div>
	<div id="dahuy" class="tab-pane fade">
		<h3>Menu 2</h3>
		<p>Some content in menu 2.</p>
	</div>
</div>


