$(function(){

  //控制考试时间的js
  /***从页面新息中获取考试时间**/
  var time = $(".wid1").eq(1).text();
  //alert(time);
  time = time.substring(time.indexOf("：")+1,time.indexOf("分"));
  //console.info("time="+time);
  /***获取考试时间js控制结束**/

  /***控制页面的考试计时器进行计时**/
  //获取计时器内容
  var timer = $("#ExamTime").text();
  //console.info("timer="+timer);
  //将字符串转化为秒数，方便计算
  var seconde = parseInt(time)*60;
  //console.info(seconde);

  //将秒钟表示的时间转化为标准的时间表示 00:00：00
  function toStandardTime (seconde){
  	var hour = parseInt(seconde / (60*60));
  	seconde = seconde - hour * 60 * 60;
  	var minute = parseInt(seconde / 60 );
  	seconde = seconde - minute * 60;
  	if(hour < 10 ){
  		hour = "0" + hour;
  	}
  	if(minute < 10 ){
  		minute = "0" + minute;
  	}
  	if(seconde < 10 ){
  		seconde = "0" + seconde;
  	}
  	return hour+":"+minute+":"+seconde;
  }
  //console.info(toStandardTime(seconde));

  //设置定时器任务,表示每隔一秒钟执行一次
  id = setInterval(function(){
  	$("#ExamTime").text(toStandardTime(seconde));
    seconde = seconde - 1;
  },1000);

  //给暂停按钮添加点击事件
  $(".time_stop").on("click",time_stop_onclick);

  //点击函数
  function time_stop_onclick(){
  	if(id!=null){
  		stopTime();
  	}else{
  		startTime();
  	}

  }
  //时间停止函数
  function stopTime(){
  	//将所有的试题隐藏
  	$(".test_body").hide();
    clearInterval(id);
    alert("暂停考试将隐藏所有试题信息");
    id = null;
  }
  //时间开始函数
  function startTime(){
  	//显示隐藏的试题
  	alert("计时开始，请在规定时间内完成答题");
  	$(".test_body").show();
  	id = setInterval(function(){
      $("#ExamTime").text(toStandardTime(seconde));
      seconde = seconde - 1;
    },1000);

  }
  /***计时器控制结束**/

  /***考试做题数目和剩余题目提示功能js控制开始**/

  //获取已题目的数量和未做题目数量
  var isdone = $(".green").eq(0).text();
  var subjectsSize = $(".green").eq(1).text();
  //console.info(isdone+"***"+isnotdone);
  //没完成一题就对两个数据进行修改（就是判断有多少个单选框被选中）
  function radioIsCheckedSum(){
  	var radios = $("input[type='radio']:checked");
    var radioIsCheckedSum = radios.length;
    //console.info(radioIsCheckedSum);
    isdone = radioIsCheckedSum;
    var isnotdone = subjectsSize - isdone;
    $(".green").eq(0).text(isdone);
    $(".green").eq(1).text(isnotdone);

  }
  //radioIsCheckedSumTaskId = setInterval(radioIsCheckedSum,1000);
  

  /***考试题目数目和剩余题目js控制结束**/
  
  /***答题卡js控制**/
  function changeTestCard(){
  	
  	//console.info("进入点击事件");
  	//调用前面定义的修改页面提示信息的方法，对已做题目数量进行修改
  	radioIsCheckedSum();
    //获取被点击的单选框所在的题目的序号
  	//console.info($(this).parent().parent().parent().parent());
    var subject_sqeuer = $(this).parent().parent().parent().parent().children().eq(0).children().eq(0).text();
    //console.info(subject_sqeuer);
    //对序号进行处理截取数字部分
    var str_start =  subject_sqeuer.indexOf("(") + 1;
    var str_stop = subject_sqeuer.indexOf(")");
    subject_sqeuer = subject_sqeuer.substring(str_start,str_stop);
    //console.info(subject_sqeuer);
    //对答题卡中的小数字进行样式的修改
    $(".cbnWrap").children().children().eq(subject_sqeuer-1).addClass("ISpan_finish");
  }
  //给单选框添加一个点击事件
  $("input[type='radio']").on("click",changeTestCard);

  //给答题卡中的提交按钮提交点击事件
  $("#test_commit").on("click",function(){
	  //test_submit();
	  if($(".green").eq(1).text()==0){
		  test_submit();
	  }else{
		  alert("请将所有的题目做完后提交试卷");
	  }
  });

  //考试提交答案函数，（为了方便手动提交和时间到了自动提交，提取成一个函数方便调用）
  function test_submit(){
  	//获取试题试题的编号，和题目编号（数据库id）和对应的答案构建一个json
	var testTitle = $(".test_title > h2").text();
	//console.info(testTitle);
	var pid = testTitle.substring(0,testTitle.indexOf("."));
	//console.info(pid);
	var JsonObject = "pid:"+pid;
	console.info(JsonObject);
	//遍历所有被选中的单选框，对其进行题目id号和用户选择的答案构成json数据{sid:answer}
	var radios = $("input[type='radio']:checked");
	for (var i = 0; i < radios.length; i++) {
		var sidText = $(radios[i]).attr("id");//页面上湖区的题目id值
		var sid = sidText.substring(0,sidText.indexOf("a"));//截取处理后的标准值
		var answer = $("label[for="+sidText+"]").text();
		JsonObject = JsonObject+","+sid+":"+answer;
		
	}
	console.info(JsonObject);
	//向后台提交数据
	$.ajax({
		type:"POST",
	    data:{"str":JsonObject},
	    url:"/EXAM/test_submit.action",
	    dataType:"TEXT",
	    success:function(result){
	    	if(result=='true'){
	    		alert("提交成功，考试列表页面");
	    		window.history.back(-1);
	    	}else{
	    		alert("系统出现故障，请重新提交");
	    	}
	    	
	    }
	});

  }

  /***答题卡js控制结束**/


});