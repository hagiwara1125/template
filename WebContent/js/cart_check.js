/*
 * 郵便番号にハイフンを挿入
 */
function postal_hyphen(num){
  num = String(num);
  var ans1 = num.substring(0,3);
  var ans2 = num.substring(3,7);
  document.write(ans1+"-"+ans2);
}

/*
 * 小数点以下切り捨て
 */
function decimal_floor(num){
  num = Math.floor(num);
  document.write(num);
}

/*
 * 引き算
 */
function subtract(x,y){
  var ans = x-y;
  ans = Math.floor(ans);
  document.write(ans);
}

/*
 * 足し算(小計)
 */
var subtotal2;
function add(x,y){
  var ans = x+y;
  ans = Math.floor(ans);
  subtotal2 =ans;
  document.write(ans);
}


/*
 * 掛け算
 */
function multiply(x,y){
  var ans = Math.floor(x*y);
  document.write(ans);
}

/*
 * 割り算
 */
function devide(x,y){
  var ans = Math.floor(x/y);
  document.write(ans);
}

/*
 * 消費税を計算
 */
function cal_tax(tax){
  var ans = subtotal2*tax;
  ans = Math.floor(ans);
  taxAmount = ans;
  document.write(ans);
}

/*
 *注文合計を計算
 */
var taxAmount;
function cal_total(){
  var ans = subtotal2+taxAmount;
  ans = Math.floor(ans);
  total1 = ans;
  document.write(ans);
}

/*
 *支払いの全合計を計算(ポイント分引いたあと)
 */
var total1;
function cal_totalAll(use_point){
  var ans = total1 - use_point;
  ans = Math.floor(ans);
  total2 = ans;
  document.write(ans);
}

/*
*獲得ポイントを計算
*/
function getPoint(x,y){
var ans = Math.trunc((x-y)*0.01);
pointGet = ans;
document.write(ans);
}