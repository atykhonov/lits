package com.lits.kunderawrk.job;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class MCTableReducer extends TableReducer<Text, IntWritable, ImmutableBytesWritable>  {

 	@SuppressWarnings("deprecation")
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
    		int i = 0;
    		for (IntWritable val : values) {
    			i += val.get();
    		}
    		Put put = new Put(Bytes.toBytes(key.toString()));
    		put.add(Bytes.toBytes("id"), Bytes.toBytes("type"), Bytes.toBytes(i));
    		
    		System.out.println("table reduced put: " + put.toString());

    		context.write(null, put);
   	}
}