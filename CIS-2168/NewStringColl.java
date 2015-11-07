/* Author: Stephen Guglielmo
 * Course: CIS-2168-03
 * Date: 2015-10-31
 * Project: StringColl and MultiStringColl assignment
 * Description: Derivate a class from MultiStringColl that does not allow duplicates.
 */

package multistringcoll;

public class NewStringColl extends MultiStringColl {
	
	public NewStringColl() {
		super();
	}
	
	public NewStringColl(int i) {
		super(i);
	}
	
	/* Do not allow duplicates. Only insert() if it isn't already in the collection.
	*/
	@Override
	public void insert(String str) {
		if (belongs(str) == 0)
			super.insert(str);
	}
}