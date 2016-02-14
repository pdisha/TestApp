package com.example.appnew.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		addItem(new DummyItem("1", "Jan"));
		addItem(new DummyItem("2", "Feb"));
		addItem(new DummyItem("3", "Mar"));
		addItem(new DummyItem("4", "Apr"));
		addItem(new DummyItem("5", "May"));
		addItem(new DummyItem("6", "Jun"));
		addItem(new DummyItem("7", "Jul"));
		addItem(new DummyItem("8", "Aug"));
		addItem(new DummyItem("9", "Sep"));
		addItem(new DummyItem("10", "Oct"));
		addItem(new DummyItem("11", "Nov"));
		addItem(new DummyItem("12", "Dec"));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
