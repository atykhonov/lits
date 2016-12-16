package com.lits.kunderawrk.job;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class MCMapper extends TableMapper<Text, IntWritable> {

	private final IntWritable ONE = new IntWritable(1);

   	private Text text = new Text();

   	public void map(ImmutableBytesWritable row, Result value, Context context) throws IOException, InterruptedException {
        
        String mediaRecordId = new String(row.get());
        String[] ids = mediaRecordId.split("::");
        String patientId = ids[0];

   		byte[] type = value.getValue(Bytes.toBytes("medical_records"), Bytes.toBytes("type"));
   		String val = patientId + " " + " - " + new String(type);
        text.set(val);
        context.write(text, ONE);
   	}
}