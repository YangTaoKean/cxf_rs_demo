package cn.itcast.cxf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import cn.itcast.cxf.domain.User;

/**
 * @author YangTao
 * @Path 服务访问资源路径
 * @Produces 生产(方法返回值),指定能否生成哪种格式返回给客户端
 * @Consumes 消费 指定能够处理客户端传递过来的数据格式
 * @GET 查询
 * @PUT 修改
 * @POST 增加
 * @DELETE 删除
 */
@Path("/userService")
@Produces("*/*")
public interface IUserService {

	@POST
	@Path("/user")
	@Consumes({ "application/xml", "application/json" })
	public void saveUser(User user);

	@PUT
	@Path("/user")
	@Consumes({ "application/xml", "application/json" })
	public void updateUser(User user);

	@GET
	@Path("/user")
	@Produces({ "application/xml", "application/json" })
	public List<User> findAllUsers();

	@GET
	@Path("/user/{id}")
	@Consumes("application/xml")
	@Produces({ "application/xml", "application/json" })
	public User finUserById(@PathParam("id") Integer id);

	@DELETE
	@Path("/user/{id}")
	@Consumes("application/xml")
	public void deleteUser(@PathParam("id") Integer id);
}
