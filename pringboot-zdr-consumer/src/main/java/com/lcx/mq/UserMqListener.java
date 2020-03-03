package com.lcx.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lcx
 * @version 1.0
 * @date 2020/3/2 23:48
 */
@Component
@RocketMQMessageListener(topic="${my.order.topic}",consumerGroup = "${my.order.consumer.group.name}",messageModel = MessageModel.BROADCASTING)
public class UserMqListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        try {
            //1,解析消息内容
            String msgId = messageExt.getMsgId();
            String tags = messageExt.getTags();
            String keys = messageExt.getKeys();
            String topic = messageExt.getTopic();
            String s = new String(messageExt.getBody(), "UTF-8");
            System.out.println("获取的msgId是："+msgId);
            System.out.println("获取的keys是："+keys);
            System.out.println("获取的topic是："+topic);
            System.out.println("获取的tags是："+tags);
            System.out.println("获取的内容是："+s);
            //2，查询消息消费记录
            //3，判断如果消费过
            //4，判断如果没有消费过
            //5，回退库存
            //6,记录消息消费日至
        }catch (Exception e){
            System.out.println("报错了："+e);
        }

    }
}
