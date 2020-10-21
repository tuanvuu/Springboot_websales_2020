<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target="#menu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/home/index"><span class="glyphicon glyphicon-home"></span> E-Shop</a>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			<ul class="nav navbar-nav">
				 <li><a href="/home/about"><span class="glyphicon glyphicon-info-sign"></span> About Us</a></li>
				 <li><a href="/home/contact"><span class="glyphicon glyphicon-phone-alt"></span> Contact Us</a></li>
				 <li><a href="/home/feedback"><span class="glyphicon glyphicon-envelope"></span> Feedback</a></li>
				 <li><a href="/home/faq"><span class="glyphicon glyphicon-question-sign"></span> FAQs</a></li>
				 <li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
						<span class="glyphicon glyphicon-user"></span> My Account
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
					
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right nn-lang">
				<li><a href="#"><img src="/static/images/en.png"></a></li>
				<li><a href="#"><img src="/static/images/vi.png"></a></li>
			</ul>
		</div>
	</div>
</nav>


