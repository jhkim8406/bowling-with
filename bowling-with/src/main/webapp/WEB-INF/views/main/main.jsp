<link href="/template/vendor/morrisjs/morris.css" rel="stylesheet">

<div id="wrapper">
       <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-2">
                   <h3 class="page-header">${mainInfo.userName } [${mainInfo.clubName }]</h3>
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
                                <div class="medium-h">${mainInfo.gameAvg }</div>
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
                                <div class="medium-h">${mainInfo.gameCount }</div>
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
                                <div class="medium-h">${mainInfo.gameAllCover }</div>
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
                                <div class="medium-h">${mainInfo.gameTwohundredOver }</div>
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
                                <div class="medium-h">${mainInfo.gameHigh }</div>
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
                                <div class="medium-h">${mainInfo.gamePerfect}</div>
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
                        <i class="fa fa-bar-chart-o fa-fw"></i> Donut Chart Example
                    </div>
                    <div class="panel-body">
                        <div id="morris-donut-chart"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Morris Charts JavaScript -->
<script src="/template/vendor/raphael/raphael.min.js"></script>
<script src="/template/vendor/morrisjs/morris.min.js"></script>
<script src="/template/data/morris-data.js"></script>
<script type="text/javascript">
$(function() {
	Morris.Donut({
	    element: 'morris-donut-chart',
	    data: [{
	        label: "Download Sales",
	        value: 12
	    }, {
	        label: "In-Store Sales",
	        value: 30
	    }, {
	        label: "Mail-Order Sales",
	        value: 20
	    }],
	    resize: true
	});
});
</script>