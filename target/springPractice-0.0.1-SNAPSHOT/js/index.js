
//prompt("in js");

$(function(){$('.form').find('input, textarea,form').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});
});



//scrolling event for bouncing arrow
$(window).scroll(function () {
	
	if ($(this).scrollTop()>0)
    {
       $('.arrow ').fadeOut();
    }
   else
    {
     $('.arrow ').fadeIn();
    }    
});


//scrolling event after clicking bouncing arrow
$(document).ready(function(){
    $(".arrow").on("click" ,function(){
    	//alert("in click event");
    	
    	    $('html,body').animate({
    	        scrollTop: $(".portion").offset().top},
    	        'slow');
    	});
    	
});




//click event for bouncing arrow
/*$('.arrow ').click(function(){
	prompt("in bounce event");
	$('html, body').animate({scrollTop : 0},800);
	return false;
});*/



//Smooth Scroll on clicking nav items
$('nav a').click(function () {
  var $href = $(this).attr('href');
  $('body').stop().animate({
    scrollTop: $($href).offset().top
  }, 1000);
  return false;
});

// back to top
/*$('#toTop a').click(function () {
  $('body').animate({
    scrollTop: 0
  }, 1000);
  return false;
});
*/





/*
// Parallaxing + add class active on scroll
$(document).scroll(function () {
  
  // parallaxing
  var $movebg = $(window).scrollTop() * -0.3;
  $('.portion').css('background-positionY', ($movebg) + 'px');

  // add class active to nav a on scroll
  var scrollPos = $(document).scrollTop() + 100;
  $('nav a').each(function () {
    var currLink = $(this);
    var refElement = $(currLink).attr("href");
    if (refElement.offset().top <= scrollPos && refElement.offset().top + refElement.height() > scrollPos)
      
    	if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
            currLink.addClass("active");
        }
        else{
            currLink.removeClass("active");
        }    
  });
  
*/
$(document).ready(function () {
    $(document).on("scroll", onScroll);
    
    //smoothscroll
    $('a[href^="#"]').on('click', function (e) {
        e.preventDefault();
        $(document).off("scroll");
        
        $('a').each(function () {
            $(this).removeClass('active');
        })
        $(this).addClass('active');
      
        var target = this.hash,
            menu = target;
        $target = $(target);
        $('html, body').stop().animate({
            'scrollTop': $target.offset().top-130
        }, 500, 'swing', function () {
            window.location.hash = target;
            $(document).on("scroll", onScroll);
        });
    });
});

function onScroll(event){
    var scrollPos = $(document).scrollTop();
    $('#menu-center a').each(function () {
        var currLink = $(this);
        var refElement = $(currLink.attr("href"));
        if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
            currLink.addClass("active");
        }
        else{
            currLink.removeClass("active");
        }
        
        
    });
    if (scrollPos > 250) {
        $('nav a').addClass('small');
        $('nav img').addClass('move');
        $('nav span').removeClass('movetext');
      } else {
        $('nav a').removeClass('small');
        $('nav img').removeClass('move');
        $('nav span').addClass('movetext');
      }
}




//adding parallax scrolling
jQuery(document).ready(function($){
	
	var doc=$(document),
	home=$('div.home');
	
	doc.on('scroll',function(){
		var curscroll=doc.scrollTop();
		home.css('background-position' , '0' + -curscroll/4 + 'px');
	});
})(jquery);


//bouncing arrow 

/*
$(window).scroll(function() {

    if ($(this).scrollTop()>0)
     {
        $('.arrow ').fadeOut();
     }
    else
     {
      $('.arrow ').fadeIn();
     }
 });


$('.arrow ').click(function(){
	$('html, body').animate({scrollTop : 0},800);
	return false;
});
*/