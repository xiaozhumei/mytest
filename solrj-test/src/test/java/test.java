import com.itheima.entity.Product;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Solrj入门示例
 */
public class test {
    //定义SolrjServer,用来操作Solr
    private SolrServer solrServer = new HttpSolrServer(
            "http://localhost:8080/solr/collection1");
    //添加或修改索引
    @Test
    public void saveOrUpdate() throws Exception {
        Product product = new Product();
        product.setPid("8000");
        product.setName("RedMi");
        product.setCatalogName("手机");
        product.setPrice(1399);
        product.setDescription("听说像素很好哦");
        product.setPicture("1.jpg");

        solrServer.addBean(product);
        //提交事务

        solrServer.commit();
    }

    //根据id删除/删除所有
    @Test
    public void deleteById() throws IOException, SolrServerException {
        //根据id删除
        solrServer.deleteById("8000");
        //删除全部
        //solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }

    //查询全部索引
    @Test
    public void query() throws Exception{
        //创建SolrQuery封装查询条件
        SolrQuery query = new SolrQuery("*:*");
        //设置分页开始记录数
        query.setStart(0);
        //设置每页显示的记录数
        query.setRows(10);
        //执行搜索，得到查询相应对象
        QueryResponse response = solrServer.query(query);
        System.out.println("搜索到的总数量："+response.getResults().getNumFound());
        //获取搜索结果，并转换成实体集合
        List<Product> products = response.getBeans(Product.class);
        for (Product product : products) {
            System.out.println("=============情人节快乐==============");
            System.out.println(product.getPid()+","+product.getName()+","+product.getCatalogName());
        }
    }
}
