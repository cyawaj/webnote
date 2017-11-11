package similar.webnote.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import similar.webnote.bean.Result;
import similar.webnote.common.CommonUtil;

@Controller
@RequestMapping("/editor")
public class EditorController extends BaseController {
	/**
	 * 删除图片
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deletePic")
	public void handler(HttpServletRequest request, HttpServletResponse response) {
		// 图片的URL
		String path = request.getParameter("path");
		Result result = new Result();
		if(path != null) {
			String resourceDirName = "webnoteData";
			String rootPath = CommonUtil.getResourceRealPath(request, resourceDirName);
			String subPath = path.substring(path.indexOf(resourceDirName) + resourceDirName.length());
			// 图片的物理路径
			String finalPath = rootPath + subPath;
			try {
				File file = new File(finalPath);
				if(file.exists()) {
					file.delete();
				}
				result.setErrcode(0);
			} catch (Exception e) {
				result.setErrcode(-1);
			}
		}
		CommonUtil.reply(response, result);
	}
}
