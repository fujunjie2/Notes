package interview;

import java.util.List;

public class Utils {

	/**
	 * Question1, sort by firstName , lastName and  ext,
	 * if firstName is the same then sort by lastName and
	 * ext, please note lastName and ext can be empty string or null
	 **/
	public static List<Extension> sortByName(List<Extension> extensions) {
		return null;
	}


	/**
	 * Question2, sort extType, extType is a string and can
	 * be "User", "Dept", "AO", "TMO", "Other",
	 * sort by User > Dept > AO > TMO > Other;
	 * There might be new extType value, it will be in last order is it's not in prefined list.
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {
		return null;
	}

	/**
	 * Question3, sum all sales items by quarter, sum the amount for the same quarter item.
	 **/
	public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
		return null;
	}

	/**
	 * Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
	 *
	 **/
	public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
		return null;
	}
    
	//Question5
	/**
	 * We have all Keys like 0-10000 with random order, it can be other keys in real cases;
	 * usedKeys is an array to store all used keys like :[2,3,4] with random order;
	 * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,....]
	 */
	
	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		return null;
	}
	
}
