$(document).ready(function() {
	$(".btn-like").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url : "/product/add-to-like/" + id,
			success : function(response) {
				if (response) {
					alert("Đã thêm vào thành công")
				} else {
					alert("Đã có sẵn")
				}
			}
		})
	})
});
