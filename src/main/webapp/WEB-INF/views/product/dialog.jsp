<div id="send-dialog" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			  <button class="close" data-dismiss="modal">&times;</button>
			  <h4 class="modal-title">Send product information</h4>
			</div>
			<div class="modal-body">
				<input id="id" type="hidden">
				<div class="form-group">
					<input id="sender" class="form-control" placeholder="Your email?">
				</div>
				<div class="form-group">
					<input id="receiver" class="form-control" placeholder="Your friend's email?">
				</div>
				<div class="form-group">
					<input id="subject" class="form-control" placeholder="Email subject?">
				</div>
				<div class="form-group">
					<textarea id="body" class="form-control" placeholder="Your message?" rows="3"></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<div class="pull-left nn-sending">
					<img src="/static/images/loading.gif">
					Sending, please wait...
				</div>
				<button class="btn btn-default btn-send">
					<span class="glyphicon glyphicon-envelope"></span> Send
				</button>
			</div>
		</div>
	</div>
</div>