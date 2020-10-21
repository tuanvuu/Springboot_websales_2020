<%@ page pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<jsp:include page="_aside-search.jsp" />

<!-- req mapping sang controller trả về view layout/_aside-category -->
<c:import url="/home/aside/category" />

<jsp:include page="_aside-hot.jsp" />


