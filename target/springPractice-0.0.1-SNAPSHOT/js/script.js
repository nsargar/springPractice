var header=document.getElementById("header");
var navbar=document.getElementById("navbar");
var bg=document.getElementById("bg");
var navbarHeight=navbar.offsetHeight;
var headerHeight=header.offsetHeight;

header.style.height=screen.height-navbarHeight;

function initParallax(){
  if(window.pageYOffset > headerHeight){
   navbar.style.position="fixed";
   navbar.style.top="0";
  }else
  {
	 navbar.style.position="absolute";
     navbar.style.top="0"; 
  }
  bg.style.top=-(window.pageYOffset/10)+"px";
}

window.addEventListener("scroll",initParallax);