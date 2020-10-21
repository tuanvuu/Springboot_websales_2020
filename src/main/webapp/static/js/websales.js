$(document).ready(function() {
	$(".btn-like").click(function(){
		var id = $(this).parents("[data-pid]").attr("data-pid")
		$.ajax({
			url:"/product/favorite/" + id,
			success: function(resp){
				alert("Đã thêm vào danh sách sản phẩm yêu thích của bạn");
			}
		})
	});
});
