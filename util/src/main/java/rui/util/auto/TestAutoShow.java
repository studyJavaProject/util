package rui.util.auto;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;


public @interface TestAutoShow {
	
	public enum Visibility{
		Query_DM_HM,
		Query_YDM_YHM,
		Query_NSRSBH_DDH,
		Query_NSRSBH_KPRQ;
		
		public boolean isVisible(Member m) {
            switch (this) {
            case Query_DM_HM:
                return true;
            case Query_YDM_YHM:
                return false;
            case Query_NSRSBH_DDH:
                return !Modifier.isPrivate(m.getModifiers());
            case Query_NSRSBH_KPRQ:
                if (Modifier.isProtected(m.getModifiers())) {
                    return true;
                }
                // fall through to public case:
            default:
                return false;
            }
		}
	}
	
	Visibility getterVisibility() default Visibility.Query_DM_HM;
}
