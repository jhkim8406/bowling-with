<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/template/vendor/morrisjs/morris.css" rel="stylesheet">
<div id="wrapper">
       <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-2">
                   <h3 class="page-header">${gameInfoByUser.userName } [${gameInfoByUser.clubName }]</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">AVG</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gameAvg }</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">GAMES</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gameCount }</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">ALL COVER</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gameAllCover }</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-red">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">200 OVER</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gameTwohundredOver }</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">HIGH</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gameHigh }</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-2 col-xs-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-4 text-left">
                                <div class="medium-s">PERFECT</div>
                            </div>
                            <div class="col-xs-8 text-right">
                                <div class="medium-h">${gameInfoByUser.gamePerfect}</div>
                            </div>
                        </div>
                    </div>
                    <a href="#">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="col-lg-1">
            	<div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-bar-chart-o fa-fw"></i> 200 Over Percent
                    </div>
                    <div class="panel-body">
                        <div id="morris-donut-chart"></div>
                    </div>
                </div>
                <div class="panel panel-default">
                	<div class="panel-heading">
                		<i class="fa fa-bar-chart-o fa-fw"></i> Average By Shop
                	</div>
                	<div class="col-lg-8">
                       	<div id="morris-bar-chart"></div>
                   	</div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Morris Charts JavaScript -->
<script src="/template/vendor/raphael/raphael.min.js"></script>
<script src="/template/vendor/morrisjs/morris.js"></script>
<script type="text/javascript">
$(function() {
	
	var gameTwohundredOverPercent = Math.floor((parseInt("${gameInfoByUser.gameTwohundredOver }") / parseInt("${gameInfoByUser.gameCount }"))*10000)/100;
	var gameTwohundredUnderPercent = (parseFloat(100) - parseFloat(gameTwohundredOverPercent));
	
	Morris.Donut({
	    element: 'morris-donut-chart',
	    data: [{
	    	label: "200 Under",
	        value: gameTwohundredUnderPercent
	    }, {
	    	label: "200 Over",
	        value: gameTwohundredOverPercent
	    }],
	    resize: true,
	    order : 'asc',
	    valueType : 'percent'
	});
	
	if("${avgScoreByUserByShop}" != null && "${avgScoreByUserByShop}" != "") {
		var dataList = new Array();
		
		<c:forEach var="item" items="${avgScoreByUserByShop}">
			var dataObj = new Object();
			dataObj.y = "${item.shopName}";
			dataObj.a = "${item.gameAvg}";
			dataObj.b = "${item.gameCount}";
			dataList.push(dataObj);
		</c:forEach>
		
		Morris.Bar({
	        element: 'morris-bar-chart',
	        data: dataList,
	        xkey: 'y',
	        ykeys: ['a','b'],
	        labels: ['Average','Games'],
	        xLabelMargin: 0,
	        maxLabelSize: 2,
	        hideHover: 'auto',
	        resize: true
	    });
	}
});
</script>