package com.internousdev.template.dto;

import java.math.BigDecimal;



/**
 * カート情報を取得・格納するためのDTOクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/19
 * @version 1.0
 */

public class NewCartDTO {

	private int cart_id;

	private int user_id;

	private int item_id;

	private String item_name;

	private BigDecimal item_price;

	private int order_count;

	private BigDecimal sub_total;

	private BigDecimal total_price;

	private String img_path;

	private int item_page;

	private int category_page;

}