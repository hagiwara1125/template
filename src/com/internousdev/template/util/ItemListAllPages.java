package com.internousdev.template.util;

import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;

/**
 * 渡されたリストに対ｔしてページネーションを行うクラス
 * @author HINAKO HAGIWARA
 * @since 2017/10/15
 * @version 1.0
 */
public class ItemListAllPages {

	/**
	 * 渡されたリストを1ページにcount個までオブジェクトが掲載された本の形に変換して返す
	 * @param list DTOが格納されたArrayList
	 * @param count 1ページあたりに掲載されるオブジェクトの個数
	 * @return displayBook 渡されたリストを1ページにcount個までオブジェクトが刑された本の形
	 */
	public ArrayList<ItemListPageObject> paginate(ArrayList<ItemDTO> list, int count) {

		ArrayList<ItemListPageObject> displayBook = new ArrayList<ItemListPageObject>();
		int itemCount = count;
		int index = 0;
		int maxPage = 0;

		if(list.size() % count == 0) {
			maxPage = list.size() / count;
		} else {
			maxPage = (list.size() / count) +1;
		}

		for(int i = index; i < itemCount; i++) {
			ItemListPageObject page = new ItemListPageObject();

			for(int j = index; j <itemCount; j++) {
				if(list.size() == j) {
					break;
				}
				page.addPaginatedList(list, j);
			}

			page.setPage_id(i);
			displayBook.add(page);

			index += count;
			itemCount += count;
		}
		return displayBook;
	}



	/**
	 * 渡されたリスト数と1ページあたりに掲載するオブジェクト数から総ページ数を返す
	 * @param list DTOが格納されたArrayList
	 * @param count 1ページあたりに掲載されるオブジェクトの個数
	 * @return maxPage 総ページ数
	 */
	public int getMaxPage(ArrayList<?> list, int count) {
		int maxPage = 0;

		if((list.size() % count) == 0) {
			maxPage = list.size() / count;
		} else {
			maxPage = (list.size() / count) + 1;
		}
		return maxPage;
	}
}