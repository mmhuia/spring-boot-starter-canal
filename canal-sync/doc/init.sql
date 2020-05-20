CREATE TABLE `t_monitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(64) DEFAULT NULL,
  `table_pk_id` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `oper_type` int(1) DEFAULT NULL COMMENT '1:insert 2:update 3:delete',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `canal_error_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `monitor_id` varchar(255) DEFAULT NULL COMMENT 'monitor表的数据主键',
  `error_detail` text COMMENT '错误信息',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


--  sys_area--------------------------------------------------------------------------------------------------------------------------------------
CREATE  TRIGGER `sys_area_insert` AFTER INSERT ON `sys_area` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'Boss' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('sys_area',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `sys_area_update` AFTER UPDATE ON `sys_area` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'Boss' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('sys_area',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `sys_area_delete` AFTER DELETE ON `sys_area` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'Boss' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('sys_area',old.id,now(),3);
	end if;
END;

--  sys_area--------------------------------------------------------------------------------------------------------------------------------------

--  zq_hostspaces_house--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_house_insert` AFTER INSERT ON `zq_hostspaces_house` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_house',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_house_update` AFTER UPDATE ON `zq_hostspaces_house` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_house',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_house_delete` AFTER DELETE ON `zq_hostspaces_house` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_house',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_house--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_floor--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_floor_insert` AFTER INSERT ON `zq_hostspaces_floor` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_floor',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_floor_update` AFTER UPDATE ON `zq_hostspaces_floor` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_floor',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_floor_delete` AFTER DELETE ON `zq_hostspaces_floor` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_floor',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_floor--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_region--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_region_insert` AFTER INSERT ON `zq_hostspaces_region` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_region',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_region_update` AFTER UPDATE ON `zq_hostspaces_region` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_region',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_region_delete` AFTER DELETE ON `zq_hostspaces_region` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_region',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_region--------------------------------------------------------------------------------------------------------------------------------------


--  zq_xy_cabinet--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_xy_cabinet_insert` AFTER INSERT ON `zq_xy_cabinet` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_cabinet',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_xy_cabinet_update` AFTER UPDATE ON `zq_xy_cabinet` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_cabinet',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_xy_cabinet_delete` AFTER DELETE ON `zq_xy_cabinet` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_cabinet',old.id,now(),3);
	end if;
END;

--  zq_xy_cabinet--------------------------------------------------------------------------------------------------------------------------------------


--  zq_xy_ulocation--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_xy_ulocation_insert` AFTER INSERT ON `zq_xy_ulocation` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_ulocation',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_xy_ulocation_update` AFTER UPDATE ON `zq_xy_ulocation` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_ulocation',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_xy_ulocation_delete` AFTER DELETE ON `zq_xy_ulocation` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_xy_ulocation',old.id,now(),3);
	end if;
END;

--  zq_xy_ulocation--------------------------------------------------------------------------------------------------------------------------------------




--  zq_ho_board--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_board_insert` AFTER INSERT ON `zq_ho_board` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_board',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_board_update` AFTER UPDATE ON `zq_ho_board` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_board',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_board_delete` AFTER DELETE ON `zq_ho_board` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_board',old.id,now(),3);
	end if;
END;

--  zq_ho_board--------------------------------------------------------------------------------------------------------------------------------------



--  zq_ho_port--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_port_insert` AFTER INSERT ON `zq_ho_port` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_port',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_port_update` AFTER UPDATE ON `zq_ho_port` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_port',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_port_delete` AFTER DELETE ON `zq_ho_port` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_port',old.id,now(),3);
	end if;
END;

--  zq_ho_port--------------------------------------------------------------------------------------------------------------------------------------






--  zq_ho_servicer--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_servicer_insert` AFTER INSERT ON `zq_ho_servicer` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_servicer',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_servicer_update` AFTER UPDATE ON `zq_ho_servicer` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_servicer',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_servicer_delete` AFTER DELETE ON `zq_ho_servicer` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_servicer',old.id,now(),3);
	end if;
END;

--  zq_ho_servicer--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_cpu--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_cpu_insert` AFTER INSERT ON `zq_hostspaces_cpu` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpu',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cpu_update` AFTER UPDATE ON `zq_hostspaces_cpu` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpu',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cpu_delete` AFTER DELETE ON `zq_hostspaces_cpu` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpu',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_cpu--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_cpumodule--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_cpumodule_insert` AFTER INSERT ON `zq_hostspaces_cpumodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpumodule',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cpumodule_update` AFTER UPDATE ON `zq_hostspaces_cpumodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpumodule',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cpumodule_delete` AFTER DELETE ON `zq_hostspaces_cpumodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cpumodule',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_cpumodule--------------------------------------------------------------------------------------------------------------------------------------

--  zq_hostspaces_cputype--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_cputype_insert` AFTER INSERT ON `zq_hostspaces_cputype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cputype',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cputype_update` AFTER UPDATE ON `zq_hostspaces_cputype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cputype',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_cputype_delete` AFTER DELETE ON `zq_hostspaces_cputype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_cputype',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_cputype--------------------------------------------------------------------------------------------------------------------------------------

--  zq_hostspaces_memory--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_memory_insert` AFTER INSERT ON `zq_hostspaces_memory` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memory',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memory_update` AFTER UPDATE ON `zq_hostspaces_memory` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memory',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memory_delete` AFTER DELETE ON `zq_hostspaces_memory` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memory',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_memory--------------------------------------------------------------------------------------------------------------------------------------



--  zq_hostspaces_memorymodule--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_memorymodule_insert` AFTER INSERT ON `zq_hostspaces_memorymodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorymodule',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memorymodule_update` AFTER UPDATE ON `zq_hostspaces_memorymodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorymodule',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memorymodule_delete` AFTER DELETE ON `zq_hostspaces_memorymodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorymodule',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_memorymodule--------------------------------------------------------------------------------------------------------------------------------------



--  zq_hostspaces_memorytype--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_memorytype_insert` AFTER INSERT ON `zq_hostspaces_memorytype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorytype',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memorytype_update` AFTER UPDATE ON `zq_hostspaces_memorytype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorytype',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_memorytype_delete` AFTER DELETE ON `zq_hostspaces_memorytype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_memorytype',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_memorytype--------------------------------------------------------------------------------------------------------------------------------------




--  zq_hostspaces_disk--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_disk_insert` AFTER INSERT ON `zq_hostspaces_disk` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disk',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_disk_update` AFTER UPDATE ON `zq_hostspaces_disk` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disk',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_disk_delete` AFTER DELETE ON `zq_hostspaces_disk` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disk',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_disk--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_diskmodule--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_diskmodule_insert` AFTER INSERT ON `zq_hostspaces_diskmodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_diskmodule',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_diskmodule_update` AFTER UPDATE ON `zq_hostspaces_diskmodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_diskmodule',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_diskmodule_delete` AFTER DELETE ON `zq_hostspaces_diskmodule` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_diskmodule',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_diskmodule--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_disktype--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_disktype_insert` AFTER INSERT ON `zq_hostspaces_disktype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disktype',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_disktype_update` AFTER UPDATE ON `zq_hostspaces_disktype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disktype',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_disktype_delete` AFTER DELETE ON `zq_hostspaces_disktype` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_disktype',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_disktype--------------------------------------------------------------------------------------------------------------------------------------




--  zq_ho_nese--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_nese_insert` AFTER INSERT ON `zq_ho_nese` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_nese',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_nese_update` AFTER UPDATE ON `zq_ho_nese` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_nese',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_nese_delete` AFTER DELETE ON `zq_ho_nese` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_nese',old.id,now(),3);
	end if;
END;

--  zq_ho_nese--------------------------------------------------------------------------------------------------------------------------------------


--  zq_ho_networkcard--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_networkcard_insert` AFTER INSERT ON `zq_ho_networkcard` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_networkcard',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_networkcard_update` AFTER UPDATE ON `zq_ho_networkcard` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_networkcard',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_networkcard_delete` AFTER DELETE ON `zq_ho_networkcard` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_networkcard',old.id,now(),3);
	end if;
END;

--  zq_ho_networkcard--------------------------------------------------------------------------------------------------------------------------------------

--  zq_ho_serversvolumes--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_ho_serversvolumes_insert` AFTER INSERT ON `zq_ho_serversvolumes` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_serversvolumes',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_ho_serversvolumes_update` AFTER UPDATE ON `zq_ho_serversvolumes` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_serversvolumes',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_ho_serversvolumes_delete` AFTER DELETE ON `zq_ho_serversvolumes` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_ho_serversvolumes',old.id,now(),3);
	end if;
END;

--  zq_ho_serversvolumes--------------------------------------------------------------------------------------------------------------------------------------

--  zq_hostspaces_node_item--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_node_item_insert` AFTER INSERT ON `zq_hostspaces_node_item` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_item',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_item_update` AFTER UPDATE ON `zq_hostspaces_node_item` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_item',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_item_delete` AFTER DELETE ON `zq_hostspaces_node_item` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_item',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_node_item--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_node_server--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_node_server_insert` AFTER INSERT ON `zq_hostspaces_node_server` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_server_update` AFTER UPDATE ON `zq_hostspaces_node_server` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_server_delete` AFTER DELETE ON `zq_hostspaces_node_server` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_node_server--------------------------------------------------------------------------------------------------------------------------------------


--  zq_hostspaces_node_server_module--------------------------------------------------------------------------------------------------------------------------------------

CREATE  TRIGGER `zq_hostspaces_node_server_module_insert` AFTER INSERT ON `zq_hostspaces_node_server_module` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server_module',new.id,now(),1);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_server_module_update` AFTER UPDATE ON `zq_hostspaces_node_server_module` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server_module',new.id,now(),2);
	end if;
END;

CREATE  TRIGGER `zq_hostspaces_node_server_module_delete` AFTER DELETE ON `zq_hostspaces_node_server_module` FOR EACH ROW BEGIN
	if SUBSTRING_INDEX(USER(),'@',1) = 'root' THEN
		insert into t_monitor(table_name,table_pk_id,create_time,oper_type)
		values('zq_hostspaces_node_server_module',old.id,now(),3);
	end if;
END;

--  zq_hostspaces_node_server_module--------------------------------------------------------------------------------------------------------------------------------------








