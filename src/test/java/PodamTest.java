import org.junit.Test;
import org.kur.practice.base.BaseClass;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategy;

/**
 * Created by Keyur on 19/8/17.
 * This Test Class Demonstrate to Auto fill data in any specified class instance using PodamFactory.
 */
public class PodamTest {

    @Test
    public void testPodamDummyPojo(){

        DataProviderStrategy strategy = RandomDataProviderStrategy.getInstance();
        PodamFactory factory = new PodamFactoryImpl(strategy);
        BaseClass dummyBaseClass = factory.manufacturePojo(BaseClass.class);
        System.out.println("Member 1: "+ dummyBaseClass.getMember1());
        System.out.println("Member 2: "+ dummyBaseClass.getMember2());
    }
}
