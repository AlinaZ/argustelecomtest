INSERT INTO Node (node_id,version,name,region,street,house) VALUES (1, 0,'node1','Russia','Lenina','17');
INSERT INTO Node (node_id,version,name,region,street,house) VALUES (2, 0,'node2','Russia','Lenina','18');
INSERT INTO Node (node_id,version,name,region,street,house) VALUES (3, 0,'node3','Russia','Lenina','25');

INSERT INTO Connector (cu_id,version,name,capacity,node_id ) VALUES (1, 0,'connector1',3,1);
INSERT INTO Connector (cu_id,version,name,capacity,node_id ) VALUES (2, 0,'connector2',1,2);
INSERT INTO Connector (cu_id,version,name,capacity,node_id ) VALUES (3, 0,'connector3',3,3);
INSERT INTO Connector (cu_id,version,name,capacity,node_id ) VALUES (4, 0,'connector4',1,2);
INSERT INTO Connector (cu_id,version,name,capacity,node_id ) VALUES (5, 0,'connector5',1,1);

INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (1,0,1,1);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (2,0,2,1);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (3,0,3,1);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (4,0,1,2);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (5,0,1,3);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (6,0,2,3);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (7,0,3,3);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (8,0,1,4);
INSERT INTO Point (point_id,version,point_cu_id,cu_id) VALUES (9,0,1,5);

INSERT INTO Page (link_id,version,point1_id,point2_id) VALUES (1,0,1,7);
INSERT INTO Page (link_id,version,point1_id,point2_id) VALUES (1,0,2,7);
INSERT INTO Page (link_id,version,point1_id,point2_id) VALUES (1,0,8,9);
INSERT INTO Page (link_id,version,point1_id,point2_id) VALUES (1,0,8,5);
INSERT INTO Page (link_id,version,point1_id,point2_id) VALUES (1,0,3,7);