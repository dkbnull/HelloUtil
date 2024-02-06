//package cn.wbnull.helloutil.util;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * bean 工具类
// *
// * @author dukunbiao(null)  2020-06-02
// * https://github.com/dkbnull/HelloUtil
// */
//@Component
//public class BeanUtils implements ApplicationContextAware {
//
//    private static ApplicationContext applicationContext;
//
//    private BeanUtils() {
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if (BeanUtils.applicationContext == null) {
//            BeanUtils.applicationContext = applicationContext;
//        }
//    }
//
//    public static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    /**
//     * 根据bean的id来查找bean
//     *
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    public static Object getBean(String id) throws Exception {
//        try {
//            return getApplicationContext().containsBean(id) ? getApplicationContext().getBean(id) : null;
//        } catch (BeansException e) {
//            throw new Exception("not found bean by id: " + id);
//        }
//    }
//
//    /**
//     * 根据bean的class来查找bean
//     *
//     * @param clazz
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    public static <T> T getBean(Class<T> clazz) throws Exception {
//        try {
//            return getApplicationContext().getBean(clazz);
//        } catch (BeansException e) {
//            throw new Exception("not found bean by class: " + clazz);
//        }
//    }
//
//    /**
//     * 根据bean的id和class来查找bean
//     *
//     * @param id
//     * @param clazz
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    public static <T> T getBean(String id, Class<T> clazz) throws Exception {
//        try {
//            return getApplicationContext().getBean(id, clazz);
//        } catch (BeansException e) {
//            throw new Exception("not found bean by id & class, id: " + id + ", class: " + clazz);
//        }
//    }
//
//    /**
//     * 根据bean的class来查找所有的bean，包括子类
//     *
//     * @param clazz
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    public static <T> Map<String, T> getBeans(Class<T> clazz) throws Exception {
//        try {
//            return getApplicationContext().getBeansOfType(clazz);
//        } catch (BeansException e) {
//            throw new Exception("not found beans by class: " + clazz);
//        }
//    }
//}
