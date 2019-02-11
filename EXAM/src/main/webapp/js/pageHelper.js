 /*自定义的自动生成前端分页的js控制*/

        /**
    	 *
    	 *动态的生成可伸缩的分页页面角标，和局部数据的跟新
    	 * count 后端传过来的分页页面总数
    	 * pageSize 页面大小
    	 * footmarkSum 可伸缩的分页角标一次显示的角标数量
    	 * url 实现跟新需要传递给后端的url
    	 * showDiv 更新数据回显的div的选择器（jquery怎么写着就怎么写）
    	 * footmarkDiv 需要生成脚标div的选择器
    	 */
    	function pageHelper(count,pageSize,footmarkSize,url,showDivSelect,footmarkDivSelect){
    		
    		/*******************实现具有伸缩效果的分页栏**************************/
        	//进行一步请求实现局部刷新表格数据
        	footmarkFun (1,footmarkSize,footmarkDivSelect);
        	var flag = 1;
        	//这里有一个坑应为是动态生成的元素所以得重新绑定点击事件
        	band_click(flag,count,pageSize,footmarkSize,url,showDivSelect,footmarkDivSelect);
        	//给下一个分页栏按钮添加点击事件 如果现在显示的时1,2页。按下按钮后就行显示3,4页
        	/**************************************************/
    		
    	}
    	
    	/********************绑定点击事件函数*************************/
    	function band_click(flag,count,pageSize,footmarkSize,url,showDivSelect,footmarkDivSelect){
         	$("a[aria-label='Next']").on("click",function(){
        		flag = flag + 1;
        		var stratFootmark = (flag-1)*footmarkSize+1;
        		var endFootMark = flag*footmarkSize;
        		
        		//数据合理化处理
        		if(stratFootmark>count){
        			stratFootmark = count;
        		}
        		if(endFootMark>count){
        			endFootMark = count;
        		}
        		//动态生成html
        		footmarkFun (stratFootmark,endFootMark,footmarkDivSelect);
        		//递归调用自身重新绑定点击事件
            	band_click(flag,count,pageSize,footmarkSize,url,showDivSelect,footmarkDivSelect);
        	});
        	//给上一个分页栏按钮添加点击事件
        	$("a[aria-label='Previous']").on("click",function(){
        		flag = flag - 1;
        		//数据合理化处理
        		if(flag<1){
        			flag = 1;
        		}
        		var stratFootmark = (flag-1)*footmarkSize+1;
        		var endFootMark = flag*footmarkSize;
        		//数据合理化处理
        		if(stratFootmark>count){
        			stratFootmark = count;
        		}
        		if(endFootMark>count){
        			endFootMark = count;
        		}
        		//动态生成html
        		footmarkFun (stratFootmark,endFootMark,footmarkDivSelect);
        		//递归调用自身重新绑定点击事件
            	band_click(flag,count,pageSize,footmarkSize,url,showDivSelect,footmarkDivSelect);
        	});
        	
        	
        	/************给分页栏上的页脚标签绑定点击事件**************/
        	$(".footmark").on("click",function(){
        		//alert("页脚被点击了")
        		var pageNumStr = $(this).text();
        		//alert(pageNumStr);
        		//发送ajax请求到后端,局部刷新数据
        		$.ajax({
        			Type:"POST",
        			url:url,
        			data:{"pageNumStr":pageNumStr,"pageSizeStr":pageSize},
        			dataType:"HTML",
        			success:function(result){
        				//alert(result)
        				$("#show").html(result);
        			}
        		});
        		
        	});
    	}
    	/*************************************************************/
    	
    	/********************动态的生成脚标函数************************/
    	function footmarkFun (stratFootmark,endFootMark,footmarkDivSelect){
	      var str1= '<nav aria-label="Page navigation">'+
		    		'  <ul class="pagination">'+
		    		'    <li>'+
		    		'      <a href="javascript:0" aria-label="Previous">'+
		    		'        <span aria-hidden="true">&laquo;</span>'+
		    		'      </a>'+
		    		'    </li>';
    		      
		  var str2= '    <li>'+
		    		'      <a href="javascript:0" aria-label="Next">'+
		    		'        <span aria-hidden="true">&raquo;</span>'+
		    		'      </a>'+
		    		'    </li>'+
		    		'  </ul>'+
		    		'</nav>';
		   var str3 = '';
		   for(var s=stratFootmark;s<=endFootMark;s++){
			   var str3 =str3+'<li class="footmark"><a href="javascript:0">'+s+'</a></li>'
		   }
		   //console.info(str1+str3+str2);
		   $(footmarkDivSelect+'').html(str1+str3+str2);
    	}
    	/**************************************************/