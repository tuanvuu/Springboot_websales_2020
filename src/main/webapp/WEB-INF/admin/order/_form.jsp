<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="http://js.nicedit.com/nicEdit-latest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<form:form modelAttribute="order" action="${prefix}/index">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Mã</label>
					<form:input path="id" class="form-control" readonly="true"
						placeholder="Auto Number" />
				</div>
				<div class="form-group col-sm-4">
					<label>Khách hàng</label>
					<form:input path="customer.id" class="form-control" />
				</div>
				<div class="form-group col-sm-4">
					<label>Địa chỉ vận chuyển</label>
					<form:input path="address" class="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-4">
					<label>Ngày đặt</label>
					<form:input path="orderDate" class="form-control datepicker" />
				</div>
				<div class="form-group col-sm-4">
					<label>Tổng cộng</label>
					<form:input path="amount" class="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label>Mô tả</label>
					<form:textarea path="description" rows="3" class="form-control" />
				</div>
				<div class="form-group col-sm-12">
					<label>Chi tiết đơn hàng</label>
					<jsp:include page="_details.jsp" />
				</div>
			</div>
		</div>

		<div class="pannel-footer text-right">
			<div class="row">
				<div class="col-sm-6 text-left">
					<div class="col-sm-3">
						<label> <input type="checkbox" name="status" value="2" />Xác
							nhận
						</label> 
					</div>
					<div class="col-sm-3">
						<label> <input type="checkbox" name="status" value="3" />Đang giao
						</label>
					</div>
					<div class="col-sm-3">
						<label> <input type="checkbox" name="status" value="0" />Hoàn tất
						</label>
					</div>
					<div class="col-sm-3">
						<label> <input type="checkbox" name="status" value="4" />Đã hủy
						</label>
					</div>
				</div>
				<div class="col-sm-6 text-right">
					<div class="pull-left text-danger">${message}${param.message}</div>
					<jsp:include page="../layout/_btn-crud.jsp" />
				</div>
			</div>

		</div>
	</div>
</form:form>
<script>
	bkLib.onDomLoaded(nicEditors.allTextAreas);
	$(function() {
		$(window).resize(function() {
			var nicedit = $("textarea").parent().find(">div");
			nicedit.css({
				"width" : "100%"
			});
			nicedit.find("[contenteditable]").width(nicedit.width() - 8);
			nicedit.find("[contenteditable]").css({
				"outline" : "none"
			});
		});
		$(window).resize();
	});
	$("input:checkbox").on('click', function() {
		// in the handler, 'this' refers to the box clicked on
		var $box = $(this);
		if ($box.is(":checked")) {
			// the name of the box is retrieved using the .attr() method
			// as it is assumed and expected to be immutable
			var group = "input:checkbox[name='" + $box.attr("name") + "']";
			// the checked state of the group/box on the other hand will change
			// and the current value is retrieved using .prop() method
			$(group).prop("checked", false);
			$box.prop("checked", true);
		} else {
			$box.prop("checked", false);
		}
	});
</script>


