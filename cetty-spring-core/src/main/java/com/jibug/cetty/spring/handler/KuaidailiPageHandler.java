package com.jibug.cetty.spring.handler;

import com.google.common.collect.Lists;
import com.jibug.cetty.core.Page;
import com.jibug.cetty.core.handler.HandlerContext;
import com.jibug.cetty.core.handler.ProcessHandlerAdapter;
import com.jibug.cetty.core.net.Proxy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author heyingcai
 */
@Component
public class KuaidailiPageHandler extends ProcessHandlerAdapter {

    @Override
    public void process(HandlerContext ctx, Page page) {

        Document document = page.getDocument();

        Elements elements = document.select("div#content>div.con-body>div>div#list>table>tbody>tr");

        List<Proxy> proxies = Lists.newArrayList();
        for (Element element : elements) {
            String ip = element.select("td[data-title=IP]").text();
            String port = element.select("td[data-title=PORT]").text();
            String scheme = element.select("td[data-title=类型]").text();
            Proxy proxy = new Proxy(ip, Integer.parseInt(port), scheme);
            proxies.add(proxy);
        }

        page.getResult().addResults(proxies);

        ctx.fireReduce(page);
    }
}
